import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import InputComponent from './component/InputComponent';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" Component={ InputComponent }></Route>
      </Routes>
    </Router>
  );
}

export default App;
