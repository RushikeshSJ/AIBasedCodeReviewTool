import React from 'react';
import FeedbackList from './FeedbackList';

const CodeReview = ({ feedback }) => {
    if (!feedback || !feedback.feedbackList || feedback.feedbackList.length === 0) {
        return <div className="code-review">No feedback available. Try submitting valid code for analysis.</div>;
    }

    return (
        <div className="code-review">
            <h2>Analysis Results</h2>
            {feedback.feedbackList.map((item, index) => (
                <FeedbackList key={index} category={item.category} message={item.message} />
            ))}
        </div>
    );
};

export default CodeReview;
