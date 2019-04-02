/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.view;

/**
 *
 * @author Barby
 */


import cluedo.Tools.LanguageString.Language;
import cluedo.Tools.LanguageString.LanguageStrings;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

 public abstract class AbstractBaseWindow extends JFrame {
  protected JMenu mHelper = new JMenu(LanguageStrings.getString("ToolBar.Helper"));
     /**
     * Declaration and definition of the MOptions menu.
     */
    JMenuItem miEnglish = new JMenuItem(LanguageStrings.getString("Menu.English"));
        JMenuItem miHungarian=new JMenuItem(LanguageStrings.getString("Menu.Hungarian"));
    protected JMenu mLanguages = new JMenu(LanguageStrings.getString("ToolBar.Languages"));
public static Set<JFrame> openedWindowsSet;
    /**
     * Declaration and definition of the mb MenuBar.
     */
    protected JMenuBar mb;
    /**
     * Declaration and definition of the miInfo MenuItem.
     */
    protected final JMenuItem miInfo = new JMenuItem(LanguageStrings.getString("ToolBar.Information"));
    public AbstractBaseWindow(){

        openedWindowsSet=new HashSet<>();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CLUEDO");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 30);
        /*setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());*/
        setResizable(false);
     //   setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        setMenu();
    }
     /**
     * This function is sets the menu.
     */
    protected void setMenu() {
        mb = new JMenuBar();
        setJMenuBar(mb);
        
        mHelper.setMnemonic('H');
        mLanguages.setMnemonic('O');
        miInfo.setMnemonic('I');
       
        mHelper.add(miInfo);
        
        mLanguages.add(miEnglish);
        mLanguages.add(miHungarian);
        mb.add(mHelper);
        mb.add(mLanguages);
        miInfo.addActionListener(showDescription());
        miEnglish.addActionListener(changeToEnglish());
        miHungarian.addActionListener(changeToHungarian());
    }
    protected ActionListener changeToHungarian(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageStrings.changeLanguage(Language.HUN);
               

              resetStringsOnWindow();
            }
        };
    }
     protected void resetStringsOnWindow(){
         miEnglish.setText(LanguageStrings.getString("Menu.English"));
         miHungarian.setText(LanguageStrings.getString("Menu.Hungarian"));
         mLanguages.setText(LanguageStrings.getString("ToolBar.Languages"));
         mHelper.setText(LanguageStrings.getString("ToolBar.Helper"));
         miInfo.setText(LanguageStrings.getString("ToolBar.Information"));
     }
    protected ActionListener changeToEnglish() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageStrings.changeLanguage(Language.ENG);

              resetStringsOnWindow();
            }
        };
    }
        /**
     * This function is showing a description of the application.
     *
     * @return with an ActionListener.
     */
    protected ActionListener showDescription() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, LanguageStrings.getString("JOptionPane.ApplicationInfo"), LanguageStrings.getString("JOptionPane.Description"), JOptionPane.INFORMATION_MESSAGE);
            }
        };
    }
  public void closeWindow(){
      if(!openedWindowsSet.isEmpty()){
                Iterator<JFrame> iter=openedWindowsSet.iterator();
                while(iter.hasNext()){
                    iter.next().dispose();
                }
            }
            doUponExit();
  }
    protected void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
      
        int answer=showConfirmation(LanguageStrings.getString("JOptionPane.ClosingApproval"), null);
        if (answer == JOptionPane.YES_OPTION) {
            
                closeWindow();
            
        }
    }  
    private static int showOptionDialogWithoutImage(String message, Object[] options){
       return JOptionPane.showOptionDialog(null, message,
               LanguageStrings.getString("JOptionPane.Approval"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
    }
    private static int showOptionDialogWithImage(String message, Object[] options, URL imageUrl){
        return JOptionPane.showOptionDialog(null, message,
                LanguageStrings.getString("JOptionPane.Approval"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(imageUrl), options, options[0]);
    }
        public static int showConfirmation(String message, URL imageUrl) {
         Object[] options = {LanguageStrings.getString("JOptionPane.Yes"), LanguageStrings.getString("JOptionPane.No")};
         int answer;
        
         if(imageUrl==null){
            answer= showOptionDialogWithoutImage(message, options);
             
         }else{
             boolean validUrl=isLinkValid(imageUrl);
             if(validUrl){
             answer=showOptionDialogWithImage(message, options, imageUrl);
             }else{
                 answer=showOptionDialogWithoutImage(message, options);
             }
         }
        return answer;
    }
        private static boolean isLinkValid(URL url){
            boolean valid=true;
         try {
            BufferedImage myPicture = ImageIO.read(url);
        } catch (IOException ex) {
            valid=false;
            System.err.println("Nem sikerült megnyitni a megjelenítendő képet!"+url.toString());
        }
         return valid;
}
     /**
     * This function os showing a Message dialog when an error occures.
     *
     * @param error
     */
    public static void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(null, error, LanguageStrings.getString("JOptionPane.ErrorTitle"), JOptionPane.ERROR_MESSAGE);
    }
    protected void doUponExit() {
        this.dispose();
    }
}
