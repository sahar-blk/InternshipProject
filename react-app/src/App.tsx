

import { Fragment } from 'react/jsx-runtime';
import { MouseEvent, useState } from 'react';
import CreateTicket from './components/CreateTicket/CreateTicket';
import TicketCard from './components/TicketCard/TicketCard';
import SupportTicketManager from './components/SupportTicketManager/SupportTicketManager';

function App() {
  let items = ["Tunisia", "Paris", "Algerie", "Maroc", "Egypte"];
  const [selectedIndex, setSelectedIndex] = useState<number>(-1);

  return (
    <>
      
      <div><CreateTicket /></div> 
    </>
  );
}



export default App;