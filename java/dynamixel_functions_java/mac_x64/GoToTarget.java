public void goToPosition(){

  while (true)
  {
    System.out.println("Press enter to continue! (or press e then enter to quit!)");
    if(scanner.nextLine().equals(KEY_FOR_ESCAPE))
      break;

 // Write goal position
 dynamixel.write4ByteTxRx(port_num, PROTOCOL_VERSION, DXL_ID, ADDR_PRO_GOAL_POSITION, dxl_goal_position[index]);
 if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION)) != COMM_SUCCESS)
 {
   dynamixel.printTxRxResult(PROTOCOL_VERSION, dxl_comm_result);
 }
 else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION)) != 0)
 {
   dynamixel.printRxPacketError(PROTOCOL_VERSION, dxl_error);
 }

 do
      {
        // Read present position
        dxl_present_position = dynamixel.read4ByteTxRx(port_num, PROTOCOL_VERSION, DXL_ID, ADDR_PRO_PRESENT_POSITION);
        if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION)) != COMM_SUCCESS)
        {
          dynamixel.printTxRxResult(PROTOCOL_VERSION, dxl_comm_result);
        }
        else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION)) != 0)
        {
          dynamixel.printRxPacketError(PROTOCOL_VERSION, dxl_error);
        }

        System.out.printf("[ID: %d] GoalPos:%d  PresPos:%d\n", DXL_ID, dxl_goal_position[index], dxl_present_position);
      }

      while ((Math.abs(dxl_goal_position[index] - dxl_present_position) > DXL_MOVING_STATUS_THRESHOLD));

      // Change goal position
      if (index == 0)
      {
        index = 1;
      }
      else
      {
        index = 0;
      }
    }
  }
}










/* 

  // Write Dynamixel#1 goal position
/* 
dynamixel.write2ByteTxRx(port_num, PROTOCOL_VERSION1, DXL1_ID, ADDR_MX_GOAL_POSITION, dxl1_goal_position[index]);


if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION1)) != COMM_SUCCESS)
{
  dynamixel.printTxRxResult(PROTOCOL_VERSION1, dxl_comm_result);
}
else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION1)) != 0)
{
  dynamixel.printRxPacketError(PROTOCOL_VERSION1, dxl_error);
}
*/


/* 
// Write Dynamixel#2 goal position
dynamixel.write4ByteTxRx(port_num, PROTOCOL_VERSION2, DXL2_ID, ADDR_PRO_GOAL_POSITION, dxl2_goal_position[index]);
if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION2)) != COMM_SUCCESS)
{
  dynamixel.printTxRxResult(PROTOCOL_VERSION2, dxl_comm_result);
}
else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION2)) != 0)
{
  dynamixel.printRxPacketError(PROTOCOL_VERSION2, dxl_error);
}
*/
/* 
do
{
  // Read Dynamixel#1 present position
  dxl1_present_position = dynamixel.read2ByteTxRx(port_num, PROTOCOL_VERSION1, DXL1_ID, ADDR_MX_PRESENT_POSITION);
  if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION1)) != COMM_SUCCESS)
  {
    dynamixel.printTxRxResult(PROTOCOL_VERSION1, dxl_comm_result);
  }
  else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION1)) != 0)
  {
    dynamixel.printRxPacketError(PROTOCOL_VERSION1, dxl_error);
  }
*/
/* 
  // Read Dynamixel#2 present position
  dxl2_present_position = dynamixel.read4ByteTxRx(port_num, PROTOCOL_VERSION2, DXL2_ID, ADDR_PRO_PRESENT_POSITION);
  if ((dxl_comm_result = dynamixel.getLastTxRxResult(port_num, PROTOCOL_VERSION2)) != COMM_SUCCESS)
  {
    dynamixel.printTxRxResult(PROTOCOL_VERSION2, dxl_comm_result);
  }
  else if ((dxl_error = dynamixel.getLastRxPacketError(port_num, PROTOCOL_VERSION2)) != 0)
  {
    dynamixel.printRxPacketError(PROTOCOL_VERSION2, dxl_error);
  }

  System.out.printf("[ID: %d] GoalPos: %d  PresPos: %d [ID: %d] GoalPos: %d  PresPos: %d\n", DXL1_ID, dxl1_goal_position[index], dxl1_present_position, DXL2_ID, dxl2_goal_position[index], dxl2_present_position);

} while ((Math.abs(dxl1_goal_position[index] - dxl1_present_position) > DXL1_MOVING_STATUS_THRESHOLD) || (Math.abs(dxl2_goal_position[index] - dxl2_present_position) > DXL2_MOVING_STATUS_THRESHOLD));


// Change goal position
if (index == 0)
{
  index = 1;
}
else
{
  index = 0;
}
*/


