# kmp-sample-android

Kotlin Multiplatform で作成された火星の不動産情報を表示する Android アプリケーションです。

本プロジェクトは [kmp-sample-library](https://github.com/kei-1111/kmp-sample-library) で実装された状態管理（ViewModel、Repository、データ層など）を使用し、**Android 側では UI 実装のみ**を行っています。これにより、ビジネスロジックとプラットフォーム固有の UI 実装を明確に分離しています。

## スクリーンショット

一覧画面 | 詳細画面
:--: | :--:
<img src="https://github.com/user-attachments/assets/56464fd7-ea10-4f7f-8876-cf655b0ad1b3" width="300" /> | <img src="https://github.com/user-attachments/assets/736745ff-7235-406e-9fa2-d38b890728c0" width="300" />




## アーキテクチャ

```
┌─────────────────────────────────────┐
│         kmp-sample-android          │
│     (UI Layer - Android Only)       │
│                                     │
│  ┌──────────┐    ┌───────────────┐ │
│  │   App    │────│Feature Module │ │
│  └──────────┘    │   (Home UI)   │ │
│                  └───────────────┘ │
│                         │          │
└─────────────────────────┼──────────┘
                          │
                          ▼
┌─────────────────────────────────────┐
│      kmp-sample-library (KMP)       │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ViewModel / Repository       │  │
│  │ State Management             │  │
│  │ Business Logic               │  │
│  │ Data Layer                   │  │
│  └──────────────────────────────┘  │
└─────────────────────────────────────┘
```

## 技術スタック

### UI 実装
- **Jetpack Compose** - モダンな宣言的 UI フレームワーク
- **Material3** - Material Design 3 コンポーネント
- **Coil** - 画像読み込みライブラリ

### 状態管理（kmp-sample-library より提供）
- **ViewModel** - UI 状態の管理
- **Repository パターン** - データ操作の抽象化
- **Koin** - 依存性注入

### ビルドシステム
- **Gradle (Kotlin DSL)** - ビルド設定
- **Convention Plugins** - ビルドロジックの共通化

## モジュール構成

```
kmp-sample-android/
├── app/                      # メインアプリケーションモジュール
├── core/
│   └── designsystem/         # デザインシステム（テーマ、共通 UI コンポーネント）
├── feature/
│   └── home/                 # ホーム画面の UI 実装
└── build-logic/             # ビルドロジック（Convention Plugins）
```

### 各モジュールの役割

- **app**: アプリケーションのエントリポイント。各機能モジュールを統合します。
- **core:designsystem**: アプリ全体で使用するテーマや UI コンポーネントを提供します。
- **feature:home**: 火星の不動産情報を表示するホーム画面の UI を実装します。ViewModel や状態管理は `kmp-sample-library` から提供されます。

## セットアップ

### 前提条件

- JDK 17 以上
- Android Studio Ladybug | 2024.2.1 以上
- Android SDK (compileSdk 36, minSdk 30)

### GitHub Packages の設定

本プロジェクトは GitHub Packages から `kmp-sample-library` を取得します。以下の設定が必要です。

1. GitHub Personal Access Token を作成（`read:packages` 権限が必要）
2. `local.properties` に以下を追加：

```properties
gpr.user=YOUR_GITHUB_USERNAME
gpr.token=YOUR_GITHUB_TOKEN
```

### ビルド手順

```bash
# リポジトリのクローン
git clone https://github.com/kei-1111/kmp-sample-android.git
cd kmp-sample-android

# ビルド
./gradlew build

# アプリの実行
./gradlew :app:installDebug
```

## 関連リポジトリ

- [kmp-sample-library](https://github.com/kei-1111/kmp-sample-library) - ビジネスロジックと状態管理を提供する Kotlin Multiplatform ライブラリ
