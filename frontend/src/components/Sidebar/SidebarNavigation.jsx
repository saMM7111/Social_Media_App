import HomeIcon from '@mui/icons-material/Home';
import ExploreIcon from '@mui/icons-material/Explore';
import ControlePointIcon from '@mui/icons-material/ControlPoint';
import NotificationIcon from '@mui/icons-material/Notifications';
import MessageIcon from '@mui/icons-material/Message';
import ListAltIcon from '@mui/icons-material/ListAlt';
import GroupIcon from '@mui/icons-material/Group';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';


export const navigationMenu = [
  {
    title: 'Home',
    icon: <HomeIcon/>,
    path: '/home'
  },
   {
    title: 'Reels',
    icon: <ExploreIcon/>,
    path: '/home/reels'
  },
   {
    title: 'Create Reels',
    icon: <ControlePointIcon/>,
    path: '/home/create-reels'
  },
   {
    title: 'Notifications',
    icon: <NotificationIcon/>,
    path: '/home/notifications'
  },
   {
    title: 'Message',
    icon: <MessageIcon/>,
    path: '/message'
  },
   {
    title: 'List',
    icon: <ListAltIcon/>,
    path: '/home/list'
  },
   {
    title: 'Communities',
    icon: <GroupIcon/>,
    path: '/home/communities'
  },
   {
    title: 'Profile',
    icon: <AccountCircleIcon/>,
    path: '/home/profile'
  }
]

export default navigationMenu;