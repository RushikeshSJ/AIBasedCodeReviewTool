import React, { useState } from 'react';
import Header from './components/Header';
import CodeInput from './components/CodeInput';
import CodeReview from './components/CodeReview';
import { analyzeCode } from './api';

const App = () => {
    const [feedback, setFeedback] = useState({ feedbackList: [] });
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleCodeSubmit = async (code) => {
        setLoading(true);
        setError(null);
        try {
            const response = await analyzeCode(code);
            setFeedback(response.data);
        } catch (error) {
            if (error.response) {
                setError(`Error ${error.response.status}: ${error.response.data.message}`);
            } else if (error.request) {
                setError('Network error: Please check your connection.');
            } else {
                setError('An unexpected error occurred.');
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="App">
            <Header />
            <CodeInput onSubmit={handleCodeSubmit} />
            {loading && <div className="loading-spinner">Loading...</div>}
            {error && <div className="error">{error}</div>}
            {feedback && feedback.feedbackList.length > 0 && <CodeReview feedback={feedback} />}
        </div>
    );
};

export default App;
