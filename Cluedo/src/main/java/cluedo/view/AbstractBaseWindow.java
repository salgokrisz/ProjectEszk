
package cluedo.view;

/**
 *Parent class of the important classes of view part. It contains rules for like
 * exiting from the game, window title, menu bar and gives method for asking for
 * approval.
 */


import static cluedo.tools.Tools.LOG;
import cluedo.tools.languagestring.Language;
import cluedo.tools.languagestring.LanguageStrings;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
protected static final String FONT_TYPE="Times New Roman";
    JMenuItem miEnglish = new JMenuItem(LanguageStrings.getString("Menu.English"));
        JMenuItem miHungarian=new JMenuItem(LanguageStrings.getString("Menu.Hungarian"));
    protected JMenu mLanguages = new JMenu(LanguageStrings.getString("ToolBar.Languages"));
protected static Set<JFrame> openedWindowsSet=new HashSet<>();

    protected JMenuBar mb;

    protected final JMenuItem miInfo = new JMenuItem(LanguageStrings.getString("ToolBar.Information"));
    public AbstractBaseWindow(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CLUEDO");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 30);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }
        });
        setMenu();
    }
    public void addToOpenedWindowsSet(JFrame window){
        openedWindowsSet.add(window);
    }
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
        return (ActionEvent e) -> {
            LanguageStrings.changeLanguage(Language.HUN);  
            resetStringsOnWindow();
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
        return (ActionEvent e) -> {
            LanguageStrings.changeLanguage(Language.ENG);
            
            resetStringsOnWindow();
        };
    }
 
    protected ActionListener showDescription() {
        return (ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, LanguageStrings.getString("JOptionPane.ApplicationInfo"), LanguageStrings.getString("JOptionPane.Description"), JOptionPane.INFORMATION_MESSAGE);
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
    protected void formWindowClosing() {                                   
      
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
            ImageIO.read(url);
        } catch (IOException ex) {
            valid=false;
            LOG.warning("Error while opening picture!"+url.toString());
        }
         return valid;
}
  
    public static void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(null, error, LanguageStrings.getString("JOptionPane.ErrorTitle"), JOptionPane.ERROR_MESSAGE);
    }
    protected void doUponExit() {
        this.dispose();
    }
}
