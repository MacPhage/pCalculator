//
//  Obskewer.java
//
//  Java Source File
//
//  Created by Austin Jackson,
//  Last modified on June 10, 2014.
//
//  Editted with Atom
//  https://atom.io/
//
//  Further updates
//  http://srchub.org/u/mac
//

import java.awt.*;
import javax.swing.*;
import Function.Add;

public class Obskewer
{
  static String titleText = "pCalculator";
  static String version = "1.0.0, last updated June 13, 2014";
  static String changes = "- Initial release"+
  ""+
  "";

  public static void main(String args[])
  {
    String in;
    String command;
    while(true)
    {
      in = JOptionPane.showInputDialog(null,"","");
      command = in.split(" ");
      if(operation.equals(""))
      {
        //
      }
      else if(operation.equals("decode"))
      {
        //
      }
      else if(operation.equals("info"))
      {
        //
      }
      else if(operation.equals("quit"))
      {
        break;
      }
      else
      {
        JOptionPane.showMessageDialog(null,"That wasn\'t a valid operation.",titleText,JOptionPane.WARNING_MESSAGE);
      }
    }
  }
  public static void doEncode()
  {
    String in = JOptionPane.showInputDialog(null,"Encoding to a Cipher...\n"+
    "Ciphers: \'ClassicShift\', \'TrueCaesar\', \'Morse\', \'(none)\'\nType your cipher type of choice: ",
    "TrueCaesar");
    if(in.equals("ClassicShift"))
    {
      ClassicShift.performEncode();
    }

    else if(in.equals("TrueCaesar"))
    {
      TrueCaesar.performEncode();
    }
    else if(in.equals("Morse"))
    {
      Morse.performEncode();
    }
    /*
    else if(in.equals("OtherCipher"))
    {
      OtherCipher.performEncode();
    }
    else if(in.equals("OtherCipher"))
    {
      OtherCipher.performEncode();
    }
    */
    else
    {
      JOptionPane.showMessageDialog(null,"That isn\'t a supported cipher.",titleText,JOptionPane.WARNING_MESSAGE);
    }
  }
  public static void doDecode()
  {
    String in = JOptionPane.showInputDialog(null,"Decoding from a Cipher...\n"+
    "Ciphers: \'ClassicShift\', \'TrueCaesar\', \'Morse\', \'(none)\'\nType your cipher type of choice: ",
    "TrueCaesar");
    if(in.equals("ClassicShift"))
    {
      ClassicShift.performDecode();
    }
    else if(in.equals("TrueCaesar"))
    {
      TrueCaesar.performDecode();
    }

    else if(in.equals("Morse"))
    {
      Morse.performDecode();
    }
    /*
    else if(in.equals("OtherCipher"))
    {
      OtherCipher.performEncode();
    }
    else if(in.equals("OtherCipher"))
    {
      OtherCipher.performEncode();
    }
    */
    else
    {
      JOptionPane.showMessageDialog(null,"That isn\'t a supported cipher.",titleText,JOptionPane.WARNING_MESSAGE);
    }
  }
  public static void showInfo()
  {
    JOptionPane.showMessageDialog(null,
    "Obskewer is a light-weight Java application for encoding and decoding text.\n"+
    "The common ciphers it supports can be found under the Encode and Decode screens.\n"+
    "\n"+
    "Version: "+version+"\n"+
    "Author: Austin Jackson\n"+
    "Official website: http://srchub.org/p/obskewer\n"+
    "Some Java implementations of the algorithms are not coded by the author\n"+
    "of this program. Please view the Credits on the offcial website for the "+
    "original authors.\n\n"+
    "Changes in this version: \n"+changes,
    "About Obskewer",JOptionPane.INFORMATION_MESSAGE);
  }
}
