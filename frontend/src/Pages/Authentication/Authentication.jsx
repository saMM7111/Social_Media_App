import React from 'react'
import { Card } from '@mui/material'
import Register from './Register'
import Login from './Login'
import { Route } from 'react-router-dom'
import { Routes } from 'react-router-dom'


const Authentication = () => {
  return (
    <div className='min-h-screen bg-white flex flex-col md:flex-row'>
      <div className='w-full md:w-7/12 h-64 md:h-screen overflow-hidden'>
        <img
          className='h-full w-full object-cover'
          src="https://cdn.pixabay.com/photo/2018/11/29/21/51/social-media-3846597_1280.png"
          alt='Social network'
        />
      </div>

      <div className='w-full md:w-5/12 flex items-center justify-center px-6 py-12 md:px-12'>
        <Card className='w-full max-w-xl p-8 shadow-md'>
          <div className='flex flex-col items-center mb-5 space-y-1'>
            <h1 className='logo text-center'>Social Media</h1>
            <p className='text-center text-sm w-[70%]'>
              Connecting Lives, Sharing Stories: Your Social World, Your Way
            </p>
          </div>

          <Routes>
            <Route path='/' element={<Login />} />
            <Route path='/login' element={<Login />} />
            <Route path='/register' element={<Register />} />
          </Routes>
        </Card>
      </div>
    </div>
  )
}

export default Authentication