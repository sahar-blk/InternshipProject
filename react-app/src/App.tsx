import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CreateTicket from './components/CreateTicket/CreateTicket';
import SupportTicketManager from './components/SupportTicketManager/SupportTicketManager';
import AgentList from './components/ListeAgents/AgentList';
import TicketTable from './components/TicketTable/TicketTable';
import ResponsiveAppBar from './components/Navbar/ResponsiveAppBar';
import ReactDOM from 'react-dom/client';

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import ClientForm from './components/ClientForm/ClientForm';

function App() {
  return (
    <>
      <ResponsiveAppBar />
      
        <Routes>
          <Route path="/table-ticket" element={<TicketTable />} />
          <Route path="/" element={<SupportTicketManager />} />
          <Route path="/create-ticket" element={<CreateTicket />} />
          <Route path="/assign-agent/:ticketId" element={<AgentList />} />
          <Route path="/client-form" element={<ClientForm />} />

        </Routes>
      
    </>
  );
}

export default App;
