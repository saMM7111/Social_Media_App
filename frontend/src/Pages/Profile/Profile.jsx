import { Avatar } from '@mui/material';
import React from 'react'
import { useParams } from 'react-router-dom';

const Profile = () => {
  return (
    <div className='py-10 w-[70%]'>
      <div className='rounded-md'>
        <div className='h-[15rem]'>
          <img className='w-full h-full rounded-t-md'
            src='https://cdn.pixabay.com/photo/2014/01/13/20/01/pebbles-243910_1280.jpg' alt=''
          />
        </div>
        <div className='px-5 flex justify-between items-start mt-5 h-[5rem]'>
          <Avatar sx={{width:"10rem",height:"10rem"}}
          src='https://images.pexels.com/photos/1520760/pexels-photo-1520760.jpeg'
          />
        </div>
      </div>
    </div>
  )
}

export default Profile
