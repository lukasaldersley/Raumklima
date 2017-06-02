using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.Devices.Bluetooth.Rfcomm;
using Windows.Devices.Enumeration;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.Networking.Sockets;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// Die Elementvorlage "Leere Seite" wird unter https://go.microsoft.com/fwlink/?LinkId=234238 dokumentiert.

namespace Raumklima
{
    /// <summary>
    /// Eine leere Seite, die eigenständig verwendet oder zu der innerhalb eines Rahmens navigiert werden kann.
    /// </summary>
    public sealed partial class ExperimentalPage : Page
    {
        byte[] buff;
        public ExperimentalPage()
        {
            this.InitializeComponent();
        }

        private StreamSocket _socket;

        private RfcommDeviceService _service;

        private async void btnSend_Click(object sender,
        RoutedEventArgs e)
        {
            int dummy;

            if (!int.TryParse(tbInput.Text, out dummy))
            {
                tbError.Text = "Invalid input";
            }

            var noOfCharsSent = await Send(tbInput.Text);

            if (noOfCharsSent != 0)
            {
                tbError.Text += noOfCharsSent.ToString();
            }
        }
        private async Task<uint> Send(string msg)
        {
            tbError.Text = string.Empty;

            try
            {
                var writer = new DataWriter(_socket.OutputStream);

                writer.WriteString(msg);

                // Launch an async task to 
                //complete the write operation
                var store = writer.StoreAsync().AsTask();
                
                var str=_socket.InputStream.AsStreamForRead();

                var receivedStrings = "";

                StreamReader read = new StreamReader(str);

                receivedStrings = read.ReadLine();

                /*str.Read(buff, 0, (int)(str.Length));

                for( int i = 0; i < buff.Length; i++)
                {
                    receivedStrings += buff[i];
                }*/


                tbError.Text += "<!>\n" + receivedStrings + "\n</!>";

                return await store;
            }
            catch (Exception ex)
            {
                tbError.Text = ex.Message;
                tbError.Text += "\n" + ex.Source + "\n" + ex.StackTrace;
                return 0;
            }
        }

        private async void btnConnect_Click(object sender,
        RoutedEventArgs e)
        {
            tbError.Text = string.Empty;

            try
            {
                var devices =
                await DeviceInformation.FindAllAsync(
                RfcommDeviceService.GetDeviceSelector(
                RfcommServiceId.SerialPort));

                var device = devices.Single(x => x.Name == "Dev B");

                _service = await RfcommDeviceService.FromIdAsync(
                device.Id);

                _socket = new StreamSocket();

                await _socket.ConnectAsync(
               _service.ConnectionHostName,
               _service.ConnectionServiceName,
               SocketProtectionLevel.
               BluetoothEncryptionAllowNullAuthentication);
                tbError.Text = "SUCCESS";
            }
            catch (Exception ex)
            {
                tbError.Text = ex.Message;
                tbError.Text += "\n" + ex.Source+"\n"+ex.StackTrace;
            }
        }

        private async void btnDisconnect_Click(object sender,
        RoutedEventArgs e)
        {
            tbError.Text = string.Empty;

            try
            {
                await _socket.CancelIOAsync();
                _socket.Dispose();
                _socket = null;
                _service.Dispose();
                _service = null;
            }
            catch (Exception ex)
            {
                tbError.Text = ex.Message;
            }
        }
    }
}