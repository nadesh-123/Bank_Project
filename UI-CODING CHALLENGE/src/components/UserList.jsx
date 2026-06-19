import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Navbar from './Navbar';

const UserList = () => {
  const deleteUser=async(id)=>{
try {
   const response=await axios.delete(`https://jsonplaceholder.typicode.com/users/${id}`)
   setUsers(users.filter(user=>user.id!=id))
} catch (error) {
  
}
  }
  const[users,setUsers]=useState([]);
  useEffect(()=>{
const getUsers=async ()=>{
try {
  const response=await axios.get("https://jsonplaceholder.typicode.com/users")
console.log(response.data)
setUsers(response.data)
} catch (error) {
 console.log(error) 

}
}
getUsers()
  },[])
  return (
    <div>
      <Navbar />
    <div>
   <table className="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
            <th scope="col">Company Name</th>
                  <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {
      users.map((user,index)=>(<tr>
      <th scope="row">{user.id}</th>
      <td>{user.name}</td>
      <td>{user.email}</td>
      <td>{user.phone}</td>
      <td>{user.company.name}</td>
      <td><button className='btn btn-danger' onClick={()=>deleteUser(user.id)}>DELETE</button></td>
    </tr>))
    }
    
   
  </tbody>
</table>  
    </div>
    </div>
  );
};

export default UserList;
