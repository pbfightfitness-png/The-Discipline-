# The Discipline — Cloud APK Build

This project is prepared for a phone-only workflow using GitHub Actions.

## What is included
- Native Android app wrapper (APK build)
- Original discipline/routine UI
- Persistent music + photo storage using IndexedDB inside the app
- 04:30 notification alarm
- Mantra counter and routine checklist
- Internet-enabled Yoddha AI panel
- GitHub Actions workflow that builds the APK automatically

## Phone-only build
1. Create a GitHub repository in your browser.
2. Upload ALL files/folders from this project to the repository root.
3. Open the repository's **Actions** tab.
4. Open **Build Android APK** and run **Run workflow**.
5. When it finishes, open the workflow run and download the artifact named `The-Discipline-debug-apk`.
6. Extract the artifact and install `app-debug.apk` on your phone.

The AI panel can use a Pollinations API key supplied by the user. Do not hard-code a secret key into the APK.
