# 🚀 Scheduler AI Whatsapp InTegration (SAWIT)

### Java Spring Boot + React UI

Aplikasi **Scheduler AI Whatsapp InTegration (SAWIT)** untuk membantu mengelola tugas, pengingat, dan aktivitas harian secara otomatis dan efisien.

Cocok digunakan untuk:

* 🧑‍💻 Produktivitas kerja
* 📅 Manajemen tugas harian
* 🏢 Operasional bisnis sederhana

---

# ✨ Fitur Utama

## 🤖 AI Generator (Gemma - Cloudflare)

* Generate pesan otomatis berbasis AI
* Format rapi & singkat
* Bahasa Indonesia
* Bisa disesuaikan dengan kebutuhan (custom prompt)
* Hasil dikirim ke whatsapp (Gunakan WA Gateway nya masing masing, sudah ada setingan nya)


---

## 📅 Scheduler (Task Management)

* Membuat dan mengelola tugas
* Penjadwalan fleksibel
* Status task:

  * Pending
  * Done
  * Failed

---

## 🌐 UI Modern (React)

* Dashboard scheduler
* Create / Edit / Delete task
* Tampilan clean & responsive

---

# 🏗️ Arsitektur

```
React (scheduler-ui)
        ↓
Spring Boot API (reminder)
        ↓
AI Service (Cloudflare - Gemma)
```

---

# ⚙️ Tech Stack

## Backend

* Java 25+
* Spring Boot
* Spring Data JPA
* PostgreSQL

## Frontend

* React.js

## AI

* Cloudflare Workers AI
* Model: Gemma

---

# 📁 Struktur Project

```
reminder/
 ├── src/main/java/...
 ├── application.properties
 ├── .env
 └── pom.xml

scheduler-ui/
 ├── src/
 ├── package.json
 └── config
```

---

# 🔐 Environment Variables

Buat file `.env`:

```
APP_NAME=reminder
APP_PORT=8989

DB_URL=jdbc:postgresql://localhost:5432/myscheduler
DB_USER=postgres
DB_PASS=postgres

OPENAI_API_KEY=your_key

CLOUDFLARE_API_TOKEN=your_token
CLOUDFLARE_ACCOUNT_ID=your_account_id
CLOUDFLARE_MODEL=@cf/google/gemma-4-26b-a4b-it
```

---

# ▶️ Cara Menjalankan

## 1. Backend (Spring Boot)

```
mvn clean install
mvn spring-boot:run
```

Akses:

```
http://localhost:8989
```

---

## 2. Frontend (React)

```
cd scheduler-ui
npm install
npm run dev
```

Akses:

```
http://localhost:5173
```

---

# 📡 API Endpoint (Contoh)

## Generate AI

```
POST /api/ai/generate
```

## Scheduler

```
GET    /api/tasks
POST   /api/tasks
PUT    /api/tasks/{id}
DELETE /api/tasks/{id}
```

---

# 🧠 Contoh Use Case

## 💼 Dunia Kerja

* Reminder meeting
* Deadline project
* Follow up pekerjaan

## 🏠 Kehidupan Sehari-hari

* Jadwal harian
* Pengingat aktivitas
* To-do list

## 🏢 Bisnis

* Manajemen tugas tim
* Reminder operasional
* Monitoring pekerjaan

---

# 🔥 Contoh Output AI

```
📌 Reminder Hari Ini

1. Meeting jam 10:00
2. Kirim laporan
3. Follow up klien
4. Review pekerjaan
5. Update progress

Semangat 💪
```

---

# ⚠️ Security Notes

* Jangan commit `.env`
* Simpan API key dengan aman
* Gunakan `.gitignore`

---

# 🤝 Kontribusi

Kontribusi sangat terbuka 🙌
Silakan fork & kembangkan sesuai kebutuhan.

---

# 📄 License

MIT License

---

# ❤️ Penutup

Project ini dibuat untuk membantu meningkatkan produktivitas dan mempermudah pengelolaan aktivitas sehari-hari dengan bantuan AI.

---
