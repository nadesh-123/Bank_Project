import React from "react";
import Navbar from "./Navbar";
import { useState } from "react";
import axios from "axios";
import { useRef } from "react";
import { Navigate, useNavigate } from "react-router-dom";
function AddUser() {
    const navigate=useNavigate()
     const toastRef = useRef(null);
    const[name,setName]=useState();
    const[email,setEmail]=useState();
    const[phone,setPhone]=useState()
    const[company,setCompany]=useState();
    const onsubmit=async(e)=>{
        e.preventDefault();
        const data={
            "name":name,
            "email":email,
            "phone":phone,
            "companyName":company
        }
        const response=await axios.post("https://jsonplaceholder.typicode.com/users",data);
        console.log(response.data);
        navigate("/user-list")
        const toastEl = toastRef.current;
    const toast = new window.bootstrap.Toast(toastEl);
    toast.show();
    }
  return (
    <div>
        <Navbar />
    <div className="container mt-5">
      <div className="card shadow">
        <div className="card-body">
          <h3 className="mb-4 text-center">Add User</h3>
          

   <div
              ref={toastRef}
            className="toast align-items-center text-bg-primary border-0 position-fixed top-0 end-0 m-3"

              role="alert"
              aria-live="assertive"
              aria-atomic="true"
            >
              <div className="d-flex">
                <div className="toast-body">User added successfully!</div>
                <button
                  type="button"
                  className="btn-close btn-close-white me-2 m-auto"
                  data-bs-dismiss="toast"
                  aria-label="Close"
                ></button>
              </div>
            </div>

          <form>
            {/* Name */}
            <div className="mb-3">
              <label htmlFor="name" className="form-label">Name</label>
              <input onChange={(e)=>setName(e.target.value)}
                type="text"
                className="form-control"
                id="name"
                placeholder="Enter full name"
              />
            </div>

            {/* Email */}
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Email</label>
              <input onChange={(e)=>setEmail(e.target.value)}
                type="email"
                className="form-control"
                id="email"
                placeholder="Enter email address"
              />
            </div>

            {/* Phone */}
            <div className="mb-3">
              <label htmlFor="phone" className="form-label">Phone</label>
              <input onChange={(e)=>setPhone(e.target.value)}
                type="tel"
                className="form-control"
                id="phone"
                placeholder="Enter phone number"
              />
            </div>

            {/* Company Name */}
            <div className="mb-3">
              <label htmlFor="company" className="form-label">Company Name</label>
              <input onChange={(e)=>setCompany(e.target.value)}
                type="text"
                className="form-control"
                id="company"
                placeholder="Enter company name"
              />
            </div>

            {/* Submit Button */}
            <button type="submit" onClick={(e)=>onsubmit(e)} className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
    </div>
  );
}

export default AddUser;
