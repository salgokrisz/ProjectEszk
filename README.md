# CLUEDO

## Terv

A választott program a CLUEDO nevű társasjáték számítógépes reprezentációja. A játék célja, hogy a játékos(ok) a pályán lépkedve gyanúsítások segítségével megoldjon/megoldjanak egy gyilkosságot. A nyertes az, aki először megszerzi az információt, és helyesen vádol.
A játékos a játék logikájával a játék grafikus user interfészén (GUI) léphet kapcsolatba. A tervezett programozási nyelv a JAVA, mert ennek van beépített adatbáziskezelője, és a GUI kialakítása is megfelelően támogatott.

## Tesztek automatikus futtatása
A teszteket az alábbi parancsokkal lehet futtatni:
- Ha abban a mappában állunk, ahol a pom.xml van, akkor:
  - mvn clean test
- Ha nem, akkor:
  - mvn -f <classpath of pom.xml> clean test
## Project buildelése
A projectet az alábbi parancsokkal lehet buildelni:
- Ha abban a mappában állunk, ahol a pom.xml van, akkor:
  - mvn clean install
- Ha nem, akkor:
  - mvn -f <classpath of pom.xml> clean install

Az install parancs a build ciklus összes fázisát lefuttatja. Ezeket a fázisokat elvégezhetjük külön parancsokkal is pl.: mvn compile,
lásd: * [Maven build fázisainak parancsai]
  
  [Maven build fázisainak parancsai]: <https://www.tutorialspoint.com/maven/maven_build_life_cycle.htm>
