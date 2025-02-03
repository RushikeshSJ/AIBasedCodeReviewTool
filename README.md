AI-Based Code Review Tool

🚀 Overview

The AI-Based Code Review Tool is an intelligent system that automates code reviews using AI. It analyzes code for best practices, security vulnerabilities, and performance optimizations while providing AI-generated feedback and refactoring suggestions.

✨ Features

✅ AI-Powered Code Analysis – Reviews syntax, structure, and logic.

🔍 Best Practices Detection – Ensures compliance with coding standards.

🛡️ Security Issue Detection – Identifies vulnerabilities like SQL injection, XSS, and hardcoded secrets.

⚡ Performance Optimization – Recommends efficient algorithms and caching strategies.

🔄 Intelligent Refactoring Suggestions – Improves readability and maintainability.

📜 Review History & Reports – Tracks past reviews and generates reports.

🛠️ Tech Stack

Backend: Java (Spring Boot)

Frontend: React

Database: MongoDB Atlas

AI Integration: OpenAI API

📦 Installation & Setup

1️⃣ Clone the Repository
git clone https://github.com/RushikeshSJ/AIBasedCodeReviewTool
cd ai-code-review-tool
2️⃣ Backend Setup (Spring Boot)
1. Navigate to the backend folder:
  cd backend
2. Install dependencies and run the backend server:
   mvn clean install
   mvn spring-boot:run
   
3️⃣ Frontend Setup (React)
1. Navigate to the frontend folder:
   cd frontend
2. Install dependencies and start the development server:
   npm install
   npm install axios
   npm start
   
4️⃣ Environment Variables
Create a .env file in the backend and frontend directories with the following variables:
# Backend
OPENAI_API_KEY=your_openai_api_key
MONGO_URI=your_mongodb_atlas_uri

# Frontend
REACT_APP_API_URL=http://localhost:8080

🚀 Usage

Open the React app in your browser.

Paste your code snippet and submit it for review.

AI generates feedback and suggests improvements.

View, analyze, and implement the suggestions.

📌 Future Enhancements

🔧 IDE Plugins – Integrate with VS Code, IntelliJ, and Eclipse.

📡 CI/CD Integration – Automate code reviews in GitHub/GitLab pipelines.

🎤 Voice-Based Code Review – AI-powered voice suggestions.

🤝 Contributing

Contributions are welcome! Feel free to submit issues and pull requests.

📜 License

This project is licensed under the MIT License.

🎯 Developed by Rushikesh Jadhav | 🚀 Happy Coding!
