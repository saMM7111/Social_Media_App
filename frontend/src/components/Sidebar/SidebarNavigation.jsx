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
    path: '/'
  },
   {
    title: 'Reels',
    icon: <ExploreIcon/>,
    path: '/'
  },
   {
    title: 'Create Reels',
    icon: <ControlePointIcon/>,
    path: '/'
  },
   {
    title: 'Notifications',
    icon: <NotificationIcon/>,
    path: '/'
  },
   {
    title: 'Message',
    icon: <MessageIcon/>,
    path: '/'
  },
   {
    title: 'List',
    icon: <ListAltIcon/>,
    path: '/'
  },
   {
    title: 'Communities',
    icon: <GroupIcon/>,
    path: '/'
  },
   {
    title: 'Profile',
    icon: <AccountCircleIcon/>,
    path: '/'
  }
]

export default navigationMenu;