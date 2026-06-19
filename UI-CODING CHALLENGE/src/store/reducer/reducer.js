const initialState={
    reduxdata:[]
}

export const reducer=(state=initialState,action)=>{
        if(action.type==="GET_ALL"){
            return{
                ...state,
                reduxdata:action.payload
            }
        }
     
        return state
}