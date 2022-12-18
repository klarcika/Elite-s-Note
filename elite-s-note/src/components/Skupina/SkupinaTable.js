import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';


export default function SkupinaTable({skupine}) {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Id</TableCell>
            <TableCell align="right">Naziv</TableCell>
            <TableCell align="right">št. uporabnikov</TableCell>

          </TableRow>
        </TableHead>
        <TableBody>
          {skupine.map((skupina) => (
            <TableRow
              key={skupina.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {skupina.id}
              </TableCell>
              <TableCell align="right">{skupina.naziv}</TableCell>
              <TableCell align="right">{skupina.stUporabnikov}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}