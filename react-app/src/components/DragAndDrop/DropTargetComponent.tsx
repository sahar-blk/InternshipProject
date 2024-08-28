import React from 'react';
import { useDrop } from 'react-dnd';
import './DropTargetComponent.css';

interface DropTargetProps {
  status: string;
  children: React.ReactNode;
  onDrop: (newStatus: string) => void;
}

const DropTargetComponent: React.FC<DropTargetProps> = ({ status, children, onDrop }) => {
  const [{ isOver }, drop] = useDrop(() => ({
    accept: 'ticket',
    drop: () => ({ status }),
    collect: (monitor) => ({
      isOver: monitor.isOver(),
    }),
  }), [status]);

  return (
    <div ref={drop} className={`drop-target ${isOver ? 'hover' : ''}`}>
      {children}
    </div>
  );
};

export default DropTargetComponent;
