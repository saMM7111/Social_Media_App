import './App.css';
import { Route, Routes } from 'react-router-dom';
import Authentication from './Pages/Authentication/Authentication';
import HomePage from './Pages/HomePage/HomePage';

function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/' element={<Authentication />} />
        <Route path='/*' element={<HomePage />} />
      </Routes>
    </div>
  );
}

export default App;