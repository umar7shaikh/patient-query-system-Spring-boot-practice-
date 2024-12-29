import React, { useState, useEffect } from 'react';
import { getAllQueries, addQuery } from '../api/patientQueryApi';

const PatientQueryList = () => {
  const [queries, setQueries] = useState([]);
  const [question, setQuestion] = useState('');
  const [response, setResponse] = useState('');

  // Fetch all queries on load
  useEffect(() => {
    fetchQueries();
  }, []);

  const fetchQueries = async () => {
    const data = await getAllQueries();
    setQueries(data);
  };

  const handleAddQuery = async () => {
    const newQuery = { question, response };
    await addQuery(newQuery);
    fetchQueries(); // Refresh list
  };

  return (
    <div>
      <h1>Patient Queries</h1>
      <ul>
        {queries.map((query) => (
          <li key={query.id}>
            {query.question} - {query.response}
          </li>
        ))}
      </ul>

      <h2>Add New Query</h2>
      <input
        type="text"
        placeholder="Question"
        value={question}
        onChange={(e) => setQuestion(e.target.value)}
      />
      <input
        type="text"
        placeholder="Response"
        value={response}
        onChange={(e) => setResponse(e.target.value)}
      />
      <button onClick={handleAddQuery}>Add Query</button>
    </div>
  );
};

export default PatientQueryList;
