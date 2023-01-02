import React, { useEffect, useState } from "react";
import api from "../../services/api";

function Vsi() {
  const [administratorji, setAdminIme] = useState([]);

  useEffect(() => {
    api.get("/administrator").then((response) => {
      console.log(response.data);
      setAdminIme(response.data);
    });
  }, []);

  return (
    <>
      <h3>Vsi admini</h3>
      {administratorji.map((admin) => {
        return (
          <span key={admin.id}>
            <h4>
              {admin.adminIme} 
            </h4>
          </span>
        );
      })}
    </>
  );
}

export default Vsi;