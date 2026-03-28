import React from 'react'
import { Avatar } from '@mui/material';
import AddIcon from '@mui/icons-material/Add';

const StoryCircle = () => {
  return (
    <div>
      <div className='flex flex-col items-center mr-4 cursor-pointer'>
          <Avatar 
          sx={{width:"5rem", height:"5rem"}}
            src='https://images.pexels.com/photos/1520760/pexels-photo-1520760.jpeg'
          >
        </Avatar>
        <p>Sam</p>
        </div>
    </div>
  )
}

export default StoryCircle
