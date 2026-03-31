import React from 'react'

const UserReelsCard = () => {
  return (
    <div className='w-[15rem] px-2'>
      <video controls className='w-full h-full rounded-md'>
        <source src="https://cdn.pixabay.com/video/2026/01/05/326081_large.mp4" type="video/mp4" />
      </video>
    </div>
  )
}

export default UserReelsCard
