import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";

import Skupina from "../Skupina/Skupina";
import Vsebina from "../Vsebina/Vsebina";
import Uporabnik from "../Uporabnik/Uporabnik";
import Seznam from "../Seznam/seznam";
import Seznam from "../Administrator/Administrator";
import PageNotFound from "../PageNotFound/PageNotFound";

export default function Routing(){
    return(
        <Routes>
            <Route path="/" element={<Vsebina />} />
            <Route path="/skupina" element={<Skupina />} />
            <Route path="/seznam" element={<Seznam />} />
            <Route path="/uporabnik" element={<Uporabnik />} />
            <Route path="/administrator" element={<Administrator />} />
            <Route path="*" element={<PageNotFound />}/>
        </Routes>
    );
}