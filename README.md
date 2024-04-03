This is a Rail Draw demo (Kotlin Multiplatform) project targeting Android, iOS, Web, Desktop.

* Contains:
    - `/composeApp/` is for code that will be shared across your Compose Multiplatform applications.
    - It contains several subfolders:
        - `/commonMain/`      is for code that’s common for all targets.
        - `/iosMain/`       subfolder for Ios.
        - `/androidMain/`   subfolder for Android.
        - `/desktopMain/`   subfolder for Desktop.
        - `/wasmJsMain/`    subfolder for Web.
    
* Debug:
    - for **Android**  Run ▶ 'uz.tashiit.composerailway.MainActivity.java'
    - for **Desktop**  Run command ▶ './gradlew :composeApp:runDistributable' or create [gradleTask](https://stackoverflow.com/a/77857453/20314223)
    - for **Web**      Run command ▶ './gradlew :composeApp:wasmJsRun' or './gradlew :composeApp:wasmJsBrowserDevelopmentRun' or create almost like [gradleTask](https://stackoverflow.com/a/77857453/20314223)
    - for **Ios**      // todo

* Release:
    - for **Android**  use menu "Build -> Build Bundles/Apks -> ..." or "Build -> Generate Signed Bundle -> ... (outputDir is 'ComposeRailway\composeApp\build\outputs\apk\debug\...')
    - for **Desktop**  use Run ▶ './gradlew :composeApp:createDistributable' (outputDir is 'root\composeApp\build\compose\binaries\main\app\...')
    - for **Web**      use Run ▶ './gradlew :composeApp:wasmjsBrowserProductionWebpack' (outputDir is 'root\composeApp\build\dist\wasmJs\...')


**Single**:
    - desktop setup installer (*.msi file) can be achieved with [this](https://www.youtube.com/watch?v=Jv_9zEkavAs)

**Note:**
    Native distributions and local execution web site - [Github](https://github.com/JetBrains/compose-multiplatform/blob/master/tutorials/Native_distributions_and_local_execution/README.md)
    Compose Multiplatform playground - [MohamedRejeb Github](https://github.com/MohamedRejeb/Compose-Geometry-Playground/)
    Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
    We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
    If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).