using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.Devices.Bluetooth;
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

// Die Elementvorlage "Leere Seite" wird unter https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x407 dokumentiert.

namespace Raumklima
{
    /// <summary>
    /// Eine leere Seite, die eigenständig verwendet oder zu der innerhalb eines Rahmens navigiert werden kann.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private StreamSocket _socket;

        private RfcommDeviceService _service;
        public MainPage()
        {
            this.InitializeComponent();
            //DataReader reader = new DataReader(_socket.InputStream);
        }

        private async void ConnectToDeviceButton_Click(object sender, RoutedEventArgs e)
        {
            info.Text = string.Empty;
            try
            {
                var devices =
                await DeviceInformation.FindAllAsync(
                RfcommDeviceService.GetDeviceSelector(
                RfcommServiceId.SerialPort));

                DeviceInformation[] dev = devices.ToArray();
                for (int i = 0; i < dev.Length; i++)
                {
                    info.Text += dev[i].Name + "\n";
                }

                var device = devices.Single(x => x.Name == "Dev B");
                _service = await RfcommDeviceService.FromIdAsync(
                device.Id);

                _socket = new StreamSocket();

                await _socket.ConnectAsync(
                _service.ConnectionHostName,
                _service.ConnectionServiceName,
                SocketProtectionLevel.
                BluetoothEncryptionAllowNullAuthentication);

                DataReader reader = new DataReader(_socket.InputStream);
                while (true)
                {
                    info.Text += reader.ReadByte();
                    //info.Text += reader.ReadString(140);//maximal 113(glaub ich aber zur sicherkeit mehr); wird zum schluss mit XXXXXX aufgefüllt
                }
            }
            catch (Exception ex)
            {
                info.Text += ex.Message + "\n";
                info.Text += ex.StackTrace + "\n";
                info.Text += ex.Source + "\n";
            }
        }


        private async void btnDisconnect_Click(object sender,
        RoutedEventArgs e)
        {
            info.Text = string.Empty;

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
                info.Text = ex.Message;
            }
        }
    }
}