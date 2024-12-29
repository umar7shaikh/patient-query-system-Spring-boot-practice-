import axios from 'axios';

// Base URL for backend API
const API_URL = 'http://localhost:8080/api/patient-queries';

// Get all queries
export const getAllQueries = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// Add a new query
export const addQuery = async (query) => {
  const response = await axios.post(API_URL, query);
  return response.data;
};
