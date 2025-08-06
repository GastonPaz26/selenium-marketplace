🚀 **Selenium Marketplace – Automated Testing Project** 🚀

*(This README is bilingual, with the English version first and the Spanish version after.)*

---

🔍 **Overview**

This repository contains my first personal project using **Selenium WebDriver** and **TestNG**. It automates a few typical scenarios on the TechPanda demo e-commerce site (accessed via the `AbstractComponent.goToLandingPage()` method) using **Java 17**, **Maven**, and the **Page Object Model (POM)** pattern. The goal is to practice writing maintainable automated tests with Selenium, TestNG, and supporting libraries. 🚀

✨ **Key Features**

- ✅ **Sort products by name**: `MobilePage` uses `selectSortBy` + `getProductNames` to choose and verify alphabetical sorting.  
- ✅ **Compare multiple products**: Data-driven (`VerifyCompareProducts.json`) comparison via `addProductsToCompare` + `ComparePopupPage`, asserting “COMPARE PRODUCTS” popup.  
- ✅ **Check price consistency**: `VerifyProductPriceConsistency` compares listing price vs. detail page price for exact match.  
- ✅ **Validate quantity limits**: `CartPage.assignInvalidQuantity(1000)` triggers error message; `VerifyQuantityLimitPerProduct` verifies limit enforcement.  

🛠️ **Technology Stack**

| Technology               | Version / Notes                                                                 |
| ------------------------ | ------------------------------------------------------------------------------- |
| 🛡️ **Java**              | 17 (Maven compiler plugin)                                                      |
| 📦 **Maven**             | Dependency management & build                                                   |
| 🌐 **Selenium WebDriver**| 4.27.0 (Java browser automation)                                                |
| 🧪 **TestNG**            | Test framework                                                                  |
| 🎋 **Cucumber** (opt.)   | BDD support (dependencies in POM, not yet used)                                  |
| 🤝 **AssertJ** (opt.)    | Fluent assertions (optional)                                                    |
| 📄 **Jackson**           | JSON data binding for test data                                                 |
| 🚗 **WebDriverManager**  | Auto-downloads browser drivers                                                  |
| 🔍 **Browsers**          | Firefox (default); override with `-Dbrowser=chrome[headless]`                    |

📂 **Repository Layout**

| Path                                | Description                                                                          |
| ----------------------------------- | ------------------------------------------------------------------------------------ |
| `src/main/java/AbstractComponents`  | Shared components: navigation & wait helpers.                                        |
| `src/main/java/pageObjects`         | Page classes: `MobilePage`, `CartPage`, `DetailProduct`, `ComparePopupPage`.         |
| `src/main/java/utils`               | Utility classes (e.g. `AssertUtils`).                                                |
| `src/main/java/resources`           | Config files (e.g. `GlobalData.properties`).                                         |
| `src/test/java/TestComponents`      | Test setup: `BaseTest` initializes WebDriver & common setup/teardown.                |
| `src/test/java/Test`                | TestNG classes implementing scenarios.                                               |
| `src/test/java/data`                | JSON test data & `DataReader.java`.                                                  |

⚡ **Getting Started**

1. **Prerequisites**: Java 17 & Maven installed. (WebDriverManager handles drivers.)  
2. **Clone**:  
   ```bash
   git clone https://github.com/GastonPaz26/selenium-marketplace.git
   cd selenium-marketplace
Select browser: Default Firefox; override via -Dbrowser=chrome or -Dbrowser=chromeheadless.

Run all tests:

bash
Copiar
Editar
mvn test
Run specific test:

bash
Copiar
Editar
mvn -Dtest=VerifySortBy test
Add tests: Create new class under src/test/java/Test, extend BaseTest, reuse/add page objects.

📝 Notes

⚠️ Educational project, not for production.

🔐 Sensitive keys (id_rsa, id_rsa.pub) included only for exercise purposes.

🚧 Future Improvements

➕ Integrate BDD with Cucumber (feature files & step defs).

🛡️ Enhance error handling & test resilience.

📈 Add more test scenarios (registration, checkout, etc.).

🚀 Selenium Marketplace – Proyecto de Automatización 🚀

🔍 Descripción general

Este repositorio contiene mi primer proyecto personal de automatización con Selenium WebDriver y TestNG. Automatiza flujos típicos en el sitio de demostración TechPanda (mediante AbstractComponent.goToLandingPage()), usando Java 17, Maven y el patrón Page Object Model (POM). El objetivo es practicar pruebas automatizadas mantenibles con Selenium, TestNG y librerías de apoyo. 🚀

✨ Funcionalidades principales

✅ Ordenar productos: MobilePage usa selectSortBy + getProductNames para verificar el orden alfabético.

✅ Comparar productos: Datos en VerifyCompareProducts.json, addProductsToCompare + ComparePopupPage, aserción de popup “COMPARE PRODUCTS”.

✅ Consistencia de precios: VerifyProductPriceConsistency compara precio en listado vs. detalle.

✅ Límites de cantidad: CartPage.assignInvalidQuantity(1000) provoca error; VerifyQuantityLimitPerProduct verifica el mensaje.

🛠️ Tecnologías

Tecnología	Versión / Notas
🛡️ Java	17
📦 Maven	Gestión de dependencias & build
🌐 Selenium WebDriver	4.27.0 (automatización de navegadores)
🧪 TestNG	Framework de pruebas
🎋 Cucumber (opt.)	BDD (dependencias en POM, sin uso aún)
🤝 AssertJ (opt.)	Aserciones fluidas (opcional)
📄 Jackson	Lectura de JSON para datos de prueba
🚗 WebDriverManager	Descarga automática de drivers de navegador
🔍 Navegadores	Firefox (por defecto); -Dbrowser=chrome[headless] para Chrome/headless

📂 Estructura del repositorio

Ruta	Descripción
src/main/java/AbstractComponents	Componentes compartidos: navegación y esperas.
src/main/java/pageObjects	Page objects: MobilePage, CartPage, DetailProduct, ComparePopupPage.
src/main/java/utils	Clases utilitarias (ej. AssertUtils).
src/main/java/resources	Archivos de configuración (GlobalData.properties).
src/test/java/TestComponents	Configuración de pruebas (BaseTest).
src/test/java/Test	Clases TestNG con escenarios.
src/test/java/data	Datos JSON de prueba & DataReader.java.

⚡ Cómo empezar

Requisitos: Instalar Java 17 y Maven. (WebDriverManager gestiona drivers.)

Clonar:

bash
Copiar
Editar
git clone https://github.com/GastonPaz26/selenium-marketplace.git
cd selenium-marketplace
Seleccionar navegador: Firefox por defecto; -Dbrowser=chrome[headless] para Chrome.

Ejecutar todas las pruebas:

bash
Copiar
Editar
mvn test
Ejecutar prueba específica:

bash
Copiar
Editar
mvn -Dtest=VerifySortBy test
Añadir pruebas: Nueva clase en src/test/java/Test, extiende BaseTest, utiliza/crea page objects.

📝 Notas

⚠️ Proyecto educativo, no para producción.

🔐 Claves sensibles incluidas solo para el ejercicio.

🚧 Mejoras futuras

➕ Integrar BDD (Cucumber: features & step defs).

🛡️ Mejorar manejo de errores y robustez.

📈 Añadir más escenarios de prueba (registro, checkout, etc.).
