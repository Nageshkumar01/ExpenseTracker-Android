# ExpenseTracker — Android Studio project

A Java Android personal-finance app using XML layouts, Material Components, MVVM, LiveData, Repository pattern, Room/SQLite and RecyclerView.

## Features
- Dashboard with all-time income, expenses and net balance
- Add, edit (tap a transaction), and delete transactions
- Offline persistence with Room database
- Recent activity and full transaction history
- Live search across description, category and notes
- Filter income versus expenses
- Monthly spending budget with progress indicator
- Basic insights summary
- Export currently visible transactions as CSV text through Android share sheet
- Input validation and empty states

## Open and run
1. Extract the ZIP.
2. In Android Studio choose **Open** and select the `ExpenseTracker` directory (the one containing `settings.gradle`).
3. Use JDK 17 and install Android SDK 35 when prompted.
4. Let Gradle sync download dependencies, then run on an emulator or Android phone.

This project uses Android Gradle Plugin 8.7.3. If Android Studio asks to create/update the Gradle wrapper, accept its recommended compatible version. A Gradle wrapper is not bundled in this ZIP.

## Package
`com.example.expensetracker`

## Notes / next steps
- Transactions are stored locally; no login or cloud sync is included.
- CSV export shares the filtered data as text; choose an app to save it or send it.
- The app stores amount values as `double` for learning purposes. A production finance app should store integer paise or use a carefully designed decimal representation.
- Budget is stored locally in app preferences and resets only if app data is cleared.
- No successful build on your specific machine/device has been verified here. If Gradle sync/build fails, send the first error from the Build window.
