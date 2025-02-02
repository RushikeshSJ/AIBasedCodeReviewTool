import React, { useState } from 'react';

const CodeInput = ({ onSubmit }) => {
    const [code, setCode] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        setError('');
        
        if (!code.trim()) {
            setError('Please enter some code before submitting.');
            return;
        }
        if (code.length < 10) {
            setError('Code seems too short. Please provide more details.');
            return;
        }
        onSubmit(code);
        setCode('');
    };

    return (
        <form onSubmit={handleSubmit} className="code-input-form">
            <textarea 
                value={code} 
                onChange={(e) => setCode(e.target.value)} 
                placeholder="Enter your code here..." 
                rows="10" 
                cols="50"
                className="code-textarea"
            />
            {error && <div className="error-message">{error}</div>}
            <button type="submit" className="submit-button">Analyze Code</button>
        </form>
    );
};

export default CodeInput;
