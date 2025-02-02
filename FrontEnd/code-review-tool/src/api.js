import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api/analyze';

export const analyzeCode = async (code) => {
    return await axios.post(API_URL, { code }, { timeout: 10000 }); // Timeout set to 10 seconds
};
