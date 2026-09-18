# Mobile UI Automation Framework - Appium

A cross-platform Android/iOS mobile UI automation framework using Java, Appium, Cucumber BDD, TestNG, Maven and Page Object Model.

## Covered scenarios
- Successful login
- Unsuccessful login
- Logout
- Add product to cart / cart validation
- Sample API tests using REST Assured

## Prerequisites
- JDK 17+
- Maven 3.9+
- Node.js
- Appium 2.x: `npm install -g appium`
- Android Studio + SDK + emulator for Android
- Xcode + iOS Simulator for iOS (macOS required)
- Sauce Labs sample app APK/IPA downloaded from the assessment release page
- Appium server running on `http://127.0.0.1:4723`

Place application files under `apps/` and update the platform properties.

## Project structure
- `base/` - driver lifecycle and reusable page functions
- `pages/` - page objects and platform-specific locators
- `stepdefinitions/` - Cucumber steps
- `hooks/` - screenshots and driver cleanup
- `utils/` - configuration, waits and screenshots
- `api/` - REST Assured API client
- `features/` - BDD scenarios
- `config/` - Android/iOS configuration

## Run Android
`mvn clean test -Dplatform=android`

## Run iOS
`mvn clean test -Dplatform=ios`

## Run API tests
`mvn clean test -DtestType=api`

## Run tags
`mvn clean test -Dplatform=android -Dcucumber.filter.tags="@smoke"`
`mvn clean test -Dplatform=android -Dcucumber.filter.tags="@regression"`

## Configuration
Platform, device name, automation engine, app path and server URL are configurable using system properties. Environment variables can also be supplied by CI and can be mapped in `ConfigReader`.

Examples:
- `-Dplatform=android`
- `-DdeviceName="Android Emulator"`
- `-DappPath="/absolute/path/to/app.apk"`
- `-DserverUrl="http://127.0.0.1:4723"`

## Failure handling
Failed scenarios capture a timestamped PNG under `reports/screenshots/`. Cucumber HTML/JSON reports are generated under `target/cucumber-reports/`.

## Locator strategy
Accessibility IDs/resource IDs are preferred. XPath is used only where a stable native identifier is not available. Platform-specific differences are kept inside page objects rather than duplicated in feature files.

## Synchronisation
Explicit waits are used instead of fixed sleeps. The framework waits for visibility/clickability and uses short polling intervals.

## Flakiness handling
- Avoid `Thread.sleep`.
- Use explicit waits.
- Reset application state between independent scenarios where practical.
- Avoid dynamic XPath indexes.
- Keep test data independent.
- Capture logs and screenshots on failure.
- Retry should be limited to known transient infrastructure failures and should not hide real defects.

## AI usage
AI was used as an engineering assistant for research, framework design discussion, Appium capability exploration, troubleshooting, refactoring suggestions and README improvement. Suggestions were reviewed, adapted and validated manually before use. No proprietary employer code or data was used.

## Confidentiality
This repository is intended for assessment purposes only. Do not add proprietary or confidential code/data from current or previous employers.
