Spring BootアプリをHerokuで公開するまで（HTTPS・PostgreSQL・Redis使用）
================================================================

# 普通にアプリを作る
- アプリを作る（コード参照）
- Gitでコミットまで行う（プッシュはまだ必要なし）

# Heroku初期化

```bash
$ heroku create heroku-sample-tada
Creating ⬢ heroku-sample-tada... done
https://heroku-sample-tada.herokuapp.com/ | https://git.heroku.com/heroku-sample-tada.git
```

- これで、Gitリモート `heroku` も追加される
- アプリ名は世界で一意でなければならない

# JDK 11を指定
デフォルトはJDK 8なので変更する。

プロジェクト直下にsystem.propertiesを作成し、下記のように記述すればOK。

```
java.runtime.version=11
```

# PostgreSQLの作成
参考URL -> https://devcenter.heroku.com/articles/heroku-postgresql

プラン一覧 -> https://elements.heroku.com/addons/heroku-postgresql#pricing

```bash
$ heroku addons:create heroku-postgresql:hobby-dev
Creating heroku-postgresql:hobby-dev on ⬢ fierce-earth-15376... free
Database has been created and is available
 ! This database is empty. If upgrading, you can transfer
 ! data from another database with pg:copy
Created postgresql-corrugated-61538 as DATABASE_URL
Use heroku addons:docs heroku-postgresql to view documentation
```

アプリのアドオンは `heroku addons` で確認可能。

```bash
$ heroku addons

Add-on                                           Plan       Price  State  
───────────────────────────────────────────────  ─────────  ─────  ───────
heroku-postgresql (postgresql-corrugated-61538)  hobby-dev  free   created
 └─ as DATABASE

The table above shows add-ons and the attachments to the current app (fierce-earth-15376) or other apps.
```

`create` することで、環境変数 `DATABASE_URL` が作成される。

```bash

```