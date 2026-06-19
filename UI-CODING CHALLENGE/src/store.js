import { configureStore } from "@reduxjs/toolkit";
import { reducer } from "./store/reducer/reducer";

export const store=configureStore({
    reducer:{
  data:reducer,
}})