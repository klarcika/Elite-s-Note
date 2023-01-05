import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import PageNotFound from "../PageNotFound/PageNotFound";
import Seznam from "../Seznam/Vsi";
import Skupina from "../Skupina/Vsi";
import Uporabnik from "../Uporabnik/Vsi";
import Vsebina from "../Vsebina/Vsi";
import Izbrisi from "../Administrator/izbriši";


function Routing() {
  return (
    <Routes>
      <Route path="/administrator/zbrisi" element={<Izbrisi />} />
      <Route path="*" element={<PageNotFound />}/>
      <Route path="/seznam" element={<Seznam />} />
      <Route path="/skupina" element={<Skupina />} />
      <Route path="/uporabnik" element={<Uporabnik />} />
      <Route path="/vsebina" element={<Vsebina />} />
    </Routes>
  );
}

export default Routing;