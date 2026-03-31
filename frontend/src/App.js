import './App.css';
import { Route, Routes } from 'react-router-dom';
import Authentication from './Pages/Authentication/Authentication';
import HomePage from './Pages/HomePage/HomePage';
import Message from './Pages/Message/Message';

function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/home' element={<HomePage />} />
        <Route path='/message' element={<Message />} />
        <Route path='/*' element={<Authentication />} />
      </Routes>
    </div>
  );
}

export default App;