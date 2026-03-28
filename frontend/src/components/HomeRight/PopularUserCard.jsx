import React from 'react'
import { Avatar, CardHeader } from '@mui/material';
import Button from '@mui/material/Button';
import { red } from '@mui/material/colors';

const PopularUserCard = () => {
  return (
    <div>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <Button size='small'>
            Follow
          </Button>
        }
        title="Sankalp Mehta"
        subheader="@sankalpmehta"
      />
    </div>
  )
}

export default PopularUserCard
