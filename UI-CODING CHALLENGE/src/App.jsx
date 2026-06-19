import { Route, Routes } from "react-router-dom";
import UserList from "./components/UserList";
import AddUser from "./components/AddUser";
import Paginated from "./components/Paginated";




const App = ()=>{

  return(
    <div>
      <Routes>
      
         <Route path="/user-list" element={<UserList />}></Route>
            <Route path="/add-user" element={<AddUser />}></Route>
             <Route path="/paginated-data" element={<Paginated />}></Route>
      </Routes>
    </div>
  )

}

export default App; 