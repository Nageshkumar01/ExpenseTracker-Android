# 💸 ExpenseTracker — Personal Finance Manager

**A clean, offline-first Android application to track income, manage expenses, monitor budgets, and understand your spending — all in one place.**

Built with **Java, XML, Material Components, MVVM, and Room Database**, ExpenseTracker makes everyday personal finance management simple, organized, and accessible without requiring an internet connection or account.

<p align="center">
  <img width="1080" height="2372" alt="DashBoard" src="https://github.com/user-attachments/assets/d71ed89a-1e5d-4f5d-802c-77400f666e6b" />
 &nbsp;
<img width="1080" height="2372" alt="AddTransaction" src="https://github.com/user-attachments/assets/75747037-90e0-4561-a87e-757d952d2c81" />
  &nbsp;
<img width="1080" height="2372" alt="AllTransaction" src="https://github.com/user-attachments/assets/97cb6756-e837-4828-b6b3-579788355d19" />
  &nbsp;
<img width="1080" height="2372" alt="RecentTransaction" src="https://github.com/user-attachments/assets/fb87e90d-d57d-48d6-a877-0eabe8e34cfa" />
</p>

<p align="center">
  <b>Home Dashboard</b> · <b>Add Transaction</b> · <b>All Transactions</b> · <b>Recent Activity</b>
</p>

---

## ✨ Overview

Managing personal finances shouldn't require complicated tools. ExpenseTracker provides a simple way to record transactions, review financial activity, and keep track of spending from your Android device.

Whether you're recording daily purchases or reviewing monthly expenses, the app keeps your financial information organized in a locally stored database.

### 🚀 Key Features

- **📊 Financial Dashboard** — View total income, total expenses, and net balance at a glance.
- **➕ Transaction Management** — Add, edit, and delete income or expense transactions.
- **🗂️ Complete Transaction History** — View and review all recorded transactions in one place.
- **🕒 Recent Activity** — Quickly access your latest financial transactions.
- **🔍 Live Search** — Search transactions by description, category, or notes.
- **🎯 Smart Filtering** — Filter transactions by income or expenses.
- **💰 Monthly Budget Tracking** — Set a monthly spending budget and monitor progress visually.
- **📈 Basic Spending Insights** — Get a quick summary of your financial activity.
- **📤 CSV Text Export** — Share currently visible transactions through Android's share sheet.
- **💾 Offline-First Storage** — Keep transaction records locally using Room and SQLite.
- **✅ Input Validation** — Validate transaction input and provide helpful empty states.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java** | Core Android application logic |
| **XML** | UI layouts and screen structure |
| **Material Components** | Material Design UI elements |
| **MVVM Architecture** | Separation of UI and application logic |
| **LiveData** | Observable data updates |
| **Repository Pattern** | Data access abstraction |
| **Room Database** | Local persistence and database access |
| **SQLite** | Local relational data storage |
| **RecyclerView** | Efficient transaction lists |
| **Android Studio** | Development environment |
| **Gradle** | Build and dependency management |

---

## 🏗️ Architecture

ExpenseTracker follows an MVVM-based architecture with a repository layer to keep UI components separate from data management.

```text
┌──────────────────────────────┐
│        XML Layouts           │
│   Activities / UI Screens    │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         ViewModel            │
│       LiveData Updates       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         Repository           │
│       Data Operations        │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        Room Database         │
│          SQLite              │
└──────────────────────────────┘
```

**Architecture benefits:**
- Separates UI code from data operations.
- Makes transaction data easier to observe and display.
- Organizes database access through a repository layer.
- Provides a maintainable foundation for future improvements.

---

## 📱 Application Screens

### 1. Home Dashboard

<p align="center">
  <img src="screenshots/home.png" alt="Home Dashboard" width="280" />
</p>

The main dashboard presents an overview of income, expenses, and net balance, helping users understand their financial position quickly.

### 2. Add Transaction

<p align="center">
  <img src="screenshots/add-transaction.png" alt="Add Transaction" width="280" />
</p>

Record a new income or expense transaction with the relevant transaction details. Input validation helps prevent incomplete or invalid entries.

### 3. View All Transactions

<p align="center">
  <img src="screenshots/view-all.png" alt="View All Transactions" width="280" />
</p>

Review transaction history, search for specific records, filter by transaction type, and tap a transaction to edit or delete it.

### 4. Recent Transactions

<p align="center">
  <img src="screenshots/recent-transactions.png" alt="Recent Transactions" width="280" />
</p>

Access recent financial activity without navigating through the entire transaction history.

---

## ⚙️ Getting Started

Follow these steps to run ExpenseTracker locally.

### Prerequisites

- Android Studio
- JDK 17
- Android SDK Platform 35
- An Android emulator or a physical Android device
- Internet access during the initial Gradle dependency download

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/YOUR-USERNAME/ExpenseTracker-Android.git
```

**2. Open the project**

Launch Android Studio and select **Open**. Choose the extracted or cloned `ExpenseTracker` directory containing `settings.gradle`.

**3. Configure the environment**

Use JDK 17 and install Android SDK 35 if Android Studio requests it.

**4. Sync Gradle**

Allow Android Studio to download the project's required Gradle plugins and dependencies. This project uses Android Gradle Plugin 8.7.3.

If the Gradle wrapper is missing from the repository, configure a compatible Gradle version through Android Studio or add a proper Gradle wrapper before using the command line.

**5. Run the application**

Connect an Android phone with USB debugging enabled or start an emulator, then click **Run ▶** in Android Studio.

---

## 📦 Build an APK

To generate an APK from Android Studio:

1. Open the project and wait for Gradle sync to complete.
2. Select **Build → Build APK(s)** or the equivalent APK build option in your Android Studio version.
3. Wait for the build to finish.
4. Locate the debug APK at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

You can install this APK on a compatible Android device or share it with someone for testing.

> **Build status:** A successful build on every machine or device has not been verified. Resolve any Gradle sync or build errors before distributing the APK.

---

## 📁 Project Structure

```text
ExpenseTracker/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/expensetracker/
│   │       │       ├── data/
│   │       │       ├── repository/
│   │       │       ├── ui/
│   │       │       └── viewmodel/
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── drawable/
│   │       │   └── values/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── screenshots/
│   ├── home.png
│   ├── add-transaction.png
│   ├── view-all.png
│   └── recent-transactions.png
├── .gitignore
├── README.md
└── settings.gradle
```

*The package and directory names shown above illustrate the intended organization. Your actual source tree may differ.*

---

## 🔐 Data & Privacy

- **Local storage:** Transaction records are stored on the device using Room/SQLite.
- **No account required:** The app does not include login or cloud synchronization.
- **Budget preferences:** The monthly budget is stored locally in app preferences and resets if app data is cleared.
- **CSV sharing:** Exported transaction text can be shared with another app using Android's share sheet.

**Important:** This is a learning project, not a certified financial application. Monetary values currently use Java `double`; production financial software should use integer paise or a carefully designed decimal representation to avoid floating-point rounding issues.

---

## 🗺️ Roadmap

Potential future improvements include:

- [ ] Monthly and yearly spending charts
- [ ] Category-wise expense breakdown
- [ ] Recurring transactions
- [ ] Dark mode
- [ ] Database backup and restore
- [ ] Export transactions as a downloadable CSV file
- [ ] Optional cloud backup and synchronization
- [ ] Automated unit and UI tests

---

## 🤝 Contributing

Contributions, suggestions, and bug reports are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Open a pull request describing your improvements.

For larger changes, consider opening an issue first to discuss the proposed feature.

---

## 👨‍💻 Author

**Nagesh Kumar**

- GitHub: [@Nageshkumar01](https://github.com/Nageshkumar01)
- Portfolio: [nageshptu.netlify.app](https://nageshptu.netlify.app/)
- Coding Profile: [Codolio](https://codolio.com/profile/nagesh01)

---

<p align="center">
  <b>ExpenseTracker</b><br/>
  Built with Java and Android — making everyday expense tracking simpler.
</p>
