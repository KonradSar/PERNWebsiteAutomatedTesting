# Project description:

This project is prepared to execute and maintain tests connected with pern.pl website. Using this script user can find
out if basic functionalities work properly. It contains UI and also some API tests as well. The following features of
PERN website are covered by tests as below:
<ol>
<li>Functional tests of basic functionalities:
<ul>
<li>searching phrases</li>
<li>displaying maps and elements</li>
<li>switching between modules</li>
<li>switching language version</li>
<li>displaying correct data and number of elements in dropDown's</li>
</ul>
</li>
<li>API tests:</li>
<ul>
<li>checking server response for selected modules displayed</li>
</ul>
</ol>

# Requirements:

It is required to add some dependencies to pom.xml file and install:
</br> <ol><li>***Oracle OpenJDK version 18.0.2***</li><li>***IntelliJ IDEA 2022.2.1***</li></ol>

```java
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>org.example</groupId>
<artifactId>pierwszyProjekt</artifactId>
<packaging>war</packaging>
<version>1.0-SNAPSHOT</version>
<properties>
<aspectj.version>1.8.10</aspectj.version>
<maven.compiler.source>18</maven.compiler.source>
<maven.compiler.target>18</maven.compiler.target>
</properties>
<name>pierwszyProjekt Maven Webapp</name>
<url>http://maven.apache.org</url>
<dependencies>
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.8.1</version>
</dependency>
<dependency>
<groupId>io.github.bonigarcia</groupId>
<artifactId>webdrivermanager</artifactId>
<version>5.3.2</version>
</dependency>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>3.8.1</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.18.24</version>
</dependency>
<dependency>
<groupId>org.assertj</groupId>
<artifactId>assertj-core</artifactId>
<version>3.16.1</version>
</dependency>
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>4.5.1</version>
</dependency>
<dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-engine</artifactId>
<version>5.9.2</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>io.qameta.allure</groupId>
<artifactId>allure-junit4</artifactId>
<version>2.21.0</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.8.1</version>
</dependency>
<dependency>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-jar-plugin</artifactId>
<version>3.0.2</version>
</dependency>
<dependency>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-gpg-plugin</artifactId>
<version>3.0.1</version>
</dependency>
<dependency>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-clean-plugin</artifactId>
<version>3.1.0</version>
</dependency>
</dependencies>
<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.0.0-M5</version>
<configuration>
<testFailureIgnore>false</testFailureIgnore>
<argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
</argLine>
<systemProperties>
<property>
<name>junit.jupiter.extensions.autodetection.enabled</name>
<value>true</value>
</property>
</systemProperties>
</configuration>
<dependencies>
<dependency>
<groupId>org.aspectj</groupId>
<artifactId>aspectjweaver</artifactId>
<version>${aspectj.version}</version>
</dependency>
</dependencies>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.8.1</version>
<configuration>
<source>12</source>
<target>12</target>
</configuration>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-war-plugin</artifactId>
<version>3.3.1</version>
</plugin>
</plugins>
<finalName>pierwszyProjekt</finalName>
</build>
</project>

```

# Some part's of the code below:

#### Setting TEST_DATA_LOCATION:

```java
public class BaseAPITest {
    protected static TestDataReader testDataReader;
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";

    @BeforeAll
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(TEST_DATA_LOCATION), StandardCharsets.UTF_8));
        testDataReader = new TestDataReader(TEST_DATA_LOCATION, new Section(properties), 
                new Strings(properties), new Strings(properties), new Strings(properties), new Section(properties));
    }
}
```

#### Some UI tests:

```java
@Test
    public void goToLaboratoryPageAndCheckDieselFlashPointValue() {
        // Given
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        assertEquals(testDataReader.getSection().getLaboratorySectionURL(), driver.getCurrentUrl());

        // When
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();

        // Then
        assertTrue(fuelsAndBiocomponentsRequirementsPage.isFlashPointCorrect());
    }
```

# How to run some UI/API tests:

#### It is required to follow the way described below:
<ol>
<li>Run some <strong>API Tests</strong>:
<ul>
<li>open <em>java/api</em> package></li>
<li>select <strong>APIFooterTest</strong>> or <strong>APISectionsOpeningTests</strong>> class</li>
<li>click right on selected class and select "Run <em>class name</em>" </li>
</ul>
</li>
<li>Run some <strong>UI Tests:</strong>
<ul>
<li>open <em>java/ui</em> package</li>
<li>select <strong>BaseLocationDetailsPageTests</strong> or <strong>DropDownMenuTests</strong> or <strong>FooterTests</strong> or <strong>FuelsAndOilsParameterTests</strong> or <strong>LanguageVersionTests</strong> or <strong>LocationsMapTests</strong> or <strong>SearchTests</strong></li>
<li>click right on selected class and select "Run <em>class name</em>" </li>
</ul>
<li>Run some Test using maven/Allure
<ul>
<li>open Intelijj Treminal and type in command: allure serve + "<em>URL to your tests reports</em>"</li>
<li>tap enter and wait until report is displayed</li>
<li>you can also use maven by selecting from right corner side menu option named <strong><em>"test"</em></strong></li>
</ul>
</li>
</ol>
