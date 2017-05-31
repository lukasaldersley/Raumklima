using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Devices.Bluetooth;
using Windows.Devices.Enumeration;
using Windows.Foundation;
using Windows.Foundation.Collections;
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
        private TextBox[] box;
        private DeviceInformation[] availableDevices;

        public MainPage()
        {
            this.InitializeComponent();
            picker.SelectionChanged += DeviceSelected;
        }

        private void DeviceSelected(object sender, SelectionChangedEventArgs e)
        {
            if (picker.SelectedIndex == 0)
            {
                //nix
            }
            else
            {
                info.Text = availableDevices[picker.SelectedIndex-1].Id + "\n" + availableDevices[picker.SelectedIndex-1].IsDefault + "\n" + availableDevices[picker.SelectedIndex-1].IsEnabled + "\n" + availableDevices[picker.SelectedIndex-1].Name + "\n" + availableDevices[picker.SelectedIndex-1].Pairing + "\n" + availableDevices[picker.SelectedIndex-1].Properties + "\n" + availableDevices[picker.SelectedIndex-1].EnclosureLocation;
            }
        }

        private async void FindDevicesButton_Click(object sender, RoutedEventArgs e)
        {
            var selector = BluetoothDevice.GetDeviceSelector();
            var devices = await DeviceInformation.FindAllAsync(selector);
            box = new TextBox[devices.Count];
            availableDevices =devices.ToArray();
            for (int i = 0; i < availableDevices.Length; i++)
            {
                box[i] = new TextBox();
                box[i].Text = availableDevices[i].Name;
                box[i].IsReadOnly = true;
                box[i].BorderThickness = new Thickness(0);
                box[i].IsHitTestVisible = false;
                //box[i].FontSize = 20;

                picker.Items.Add(box[i]);
            }
        }

        private void ConnectToDeviceButton_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
