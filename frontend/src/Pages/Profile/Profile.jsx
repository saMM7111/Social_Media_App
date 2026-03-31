import { Avatar } from '@mui/material';
import React from 'react'
import { useParams } from 'react-router-dom';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Postcard from '../../components/Post/Postcard';
import { Card } from '@mui/material';
import UserReelsCard from '../../components/Reels/UserReelsCard';


const tabs = [
  {value: "posts", name: "Posts"},
  {value: "reels", name: "Reels"},
  {value: "saved", name: "Saved"},
  {value: "repost", name:"Repost"}
];
const posts = [1,1,1,1];
const reels = [1,1,1,1];
const savedPosts = [1,1,1,1];
const Profile = () => {
  const [value, setValue] = React.useState('posts');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };  
  return (
    <Card className='my-10 w-[70%]'>
      <div className='rounded-md'>
        <div className='h-[15rem]'>
          <img className='w-full h-full rounded-t-md'
            src='https://cdn.pixabay.com/photo/2014/01/13/20/01/pebbles-243910_1280.jpg' alt=''
          />
        </div>
        <div className='px-5 flex justify-between items-start mt-5 h-[5rem]'>
          <Avatar className='transform -translate-y-24' sx={{width:"10rem",height:"10rem"}}
          src='https://images.pexels.com/photos/1520760/pexels-photo-1520760.jpeg'
          />

          {true? <Button sx={{borderRadius:"20px"}} variant='outlined'>Edit Profile</Button>: <Button variant='contained'>Follow</Button>}
        </div>
        <div className='p-5'>

          <div>
            <h1 className='py-1 font-bold text-xl'>John Doe</h1>
            <p>@jhonDoe</p>
          </div>
          <div className='flex gap-5 items-center py-3'>
            <span>41 posts</span>
            <span>1.2k followers</span>
            <span>500 following</span>
          </div>

          <div>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas, voluptate.</p>
          </div>

          <section>
            <Box sx={{ width: '100%', borderBottom: 1, borderColor: 'divider', mt:3 }}>
              <Tabs
                value={value}
                onChange={handleChange}
                aria-label="wrapped label tabs example"
              >
                {tabs.map((item)=><Tab value={item.value} label={item.name} wrapped/>)}
              </Tabs>
            </Box>
            <div className='flex justify-center'>
              {value==="posts"?(
                <div className='space-y-5 w-[70%] my-10'>
                  {posts.map((item)=> (<div className='border border-slate-100 rounded-md'>
                    <Postcard/>
                  </div>))}
                </div>
              ):value === "reels"?(
                <div className='flex justify-center flex-wrap gap-2 my-10'>
                  {reels.map((item)=>
                    <UserReelsCard/>
                  )}
                </div>
              ):value === "saved"?(
                <div className='space-y-5 w-[70%] my-10'>
                  {savedPosts.map((item)=> (<div className='border border-slate-100 rounded-md'>
                    <Postcard/>
                  </div>))}
                </div>
              ):value === "repost"?(
                <div>
                  Repost
                </div>
              ):""}
            </div>
          </section>
        </div>
      </div>
    </Card>
  )
}

export default Profile
