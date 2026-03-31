import './App.css';
import { Route, Routes } from 'react-router-dom';
import Authentication from './Pages/Authentication/Authentication';
import HomePage from './Pages/HomePage/HomePage';
import Message from './Pages/Message/Message';
import { useSelector } from 'react-redux';
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { getProfileAction } from './Redux/Auth/authAction';

function App() {
  const auth = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const jwt = localStorage.getItem('jwt');
  useEffect(() => {
    if (jwt) {
      dispatch(getProfileAction(jwt));
    }
  }, [jwt, dispatch]);
  
  return (
    <div className="">
      <Routes>
        <Route path='/home/*' element={auth.user ? <HomePage /> : <Authentication />} />
        <Route path='/message' element={<Message />} />
        <Route path='/*' element={<Authentication />} />
      </Routes>
    </div>
  );
}

export default App;