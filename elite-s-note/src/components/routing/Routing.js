import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";

import Skupina from "../Skupina/Skupina";
import Vsebina from "../Vsebina/Vsebina";
import PageNotFound from "../PageNotFound/PageNotFound";

export default function Routing(){
    return(
        <Routes>
             <Route path="/" element={<Vsebina />} />
            <Route path="/skupina" element={<Skupina />} />
            <Route path="*" element={<PageNotFound />}/>
        </Routes>
    );
}