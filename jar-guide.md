# Tilføj et eksternt JAR-bibliotek (fx Gson) i IntelliJ

Denne vejledning viser, hvordan du tilføjer et eksternt JAR‑bibliotek til et Java‑projekt i IntelliJ.

---

## 1. Download biblioteket (Gson)

Hent JAR-filen her:

**Download:**  
https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar

Læg filen i dit projekt, fx:

```
MyProject/
 ├─ src/
 ├─ libs/
 │   └─ gson-2.11.0.jar
```

---

## 2. Åbn *Project Structure*

I IntelliJ:

- **File → Project Structure…**  
  eller  
- `Ctrl + Alt + Shift + S`  
  eller  
- `F4` når projektet er markeret

---

## 3. Vælg **Modules**

I venstre menu:

**Project Settings → Modules**

Vælg modulet (typisk samme navn som projektet).

---

##  4. Gå til fanen **Dependencies**

Øverst finder du fanerne:

```
Sources | Paths | Dependencies
```

Klik på **Dependencies**.

---

## 5. Klik på det grå **+** og tilføj JAR-filen

1. Klik på **+** (Add)
2. Vælg **“JARs or Directories…”**
3. Find filen:

```
libs/gson-2.11.0.jar
```

4. Bekræft → Scope skal være **Compile**
5. Tryk **Apply → OK**

---

## 6. Test at biblioteket virker i din Java-kode

```java
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println("Gson virker!");
    }
}
```

---

# Alternativ løsning: Maven-projekt

Hvis projektet i stedet **er et Maven-projekt** (hvilket er mere professionel løsning), skal JAR‑filer **ikke** tilføjes manuelt.  
I stedet tilføjer du biblioteket i `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

Maven downloader automatisk biblioteket og lægger det på classpath.

---

# Kort opsummering

| Trin | Handling |
|------|----------|
| 1 | Download `.jar` |
| 2 | Åbn Project Structure |
| 3 | Vælg Modules |
| 4 | Gå til Dependencies |
| 5 | + → JARs or Directories |
| 6 | Importér Gson i Java |
