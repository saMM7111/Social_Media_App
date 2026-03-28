import React from 'react';
import { navigationMenu } from '../../components/Sidebar/SidebarNavigation';
import { Avatar, Divider } from '@mui/material';
import Button from '@mui/material/Button';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import { Card } from '@mui/material';

export const Sidebar = () => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  return (
    <Card className='card h-screen flex flex-col justify-between py-5'>

      <div className='space-y-8 pl-5'>

        <div className=''>

          <span className='logo text-bold text-xl'>Social Media</span>

        </div>

        <div className='space-y-8'>
          {navigationMenu.map((item) => <div className='cursor-pointer flex space-x-3 item-center'>
            {item.icon}
            <p className='text-xl'>{item.title}</p>
          </div>)}

        </div>

      </div>

      <div>
        <Divider />
        <div className='pl-5 flex items-center justify-between pt-5'>
          <div className='flex items-center space-x-3'>

            <Avatar src='https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_960_720.png' />
            <div>
              <p className='font-bold'>Sankalp</p>
              <p className='opacity-70'>@sankalp</p>
            </div>
          </div>
            <Button
              id="basic-button"
              aria-controls={open ? 'basic-menu' : undefined}
              aria-haspopup="true"
              aria-expanded={open ? 'true' : undefined}
              onClick={handleClick}
            >
              <MoreVertIcon />
            </Button>
            <Menu
              id="basic-menu"
              anchorEl={anchorEl}
              open={open}
              onClose={handleClose}
              slotProps={{
                list: {
                  'aria-labelledby': 'basic-button',
                },
              }}
            >
              <MenuItem onClick={handleClose}>Profile</MenuItem>
              <MenuItem onClick={handleClose}>My account</MenuItem>
              <MenuItem onClick={handleClose}>Logout</MenuItem>
            </Menu>
        </div>
      </div>
    </Card>
  )
}

export default Sidebar;