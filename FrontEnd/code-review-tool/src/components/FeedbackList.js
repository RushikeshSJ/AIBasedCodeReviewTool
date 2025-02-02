import React from 'react';

const FeedbackList = ({ category, message }) => {
    return (
        <div className="feedback-item">
            <h3>{category}</h3>
            <p>{message}</p>
        </div>
    );
};

export default FeedbackList;
