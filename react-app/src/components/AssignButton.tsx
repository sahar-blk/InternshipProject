import React from 'react';
import Button from '@mui/material/Button';
import { styled } from '@mui/system';

const AssignerButton = styled(Button)({
  backgroundColor: '#ff3b00', // Adjust the color to match the image
  color: 'white',
  fontSize: '1.5rem', // Adjust the size to match the image
  textTransform: 'none',
  '&:hover': {
    backgroundColor: '#ff3b00', // Keep the hover color the same
  },
});

const AssignButton = () => {
  return <AssignerButton>Assigner</AssignerButton>;
};

export default AssignButton;
