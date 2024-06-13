import React, {useState} from 'react';
import {View, Text, SafeAreaView, Button, StyleSheet} from 'react-native';
import {initUHF, setScanMode, startScan, stopScan} from './uhfsdk/uhf';

const App = () => {
  const [isSwitchOn, setSwitchOn] = useState(false);

  const toggleSwitch = () => {
    setSwitchOn(!isSwitchOn);
    if (!isSwitchOn) {
      initUHF((init: boolean) => {
        if (init) {
          setScanMode(1, (result: boolean) => {
            if (result) {
              startScan((started: boolean) => {
                console.log('Scan started:', started);
              });
            }
          });
        }
      });
    } else {
      stopScan(() => {
        console.log('Scan stopped');
      });
    }
  };

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.content}>
        <Text style={styles.title}>React Native UHF Integration</Text>
        <Text style={styles.appName}>App Name: HHT Switcher</Text>
        <Text style={styles.switchValue}>
          Switch Value: {isSwitchOn ? 'ON' : 'OFF'}
        </Text>
        <Button title="Toggle" onPress={toggleSwitch} />
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  content: {
    padding: 16,
    backgroundColor: '#f5f5f5',
    borderRadius: 8,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 8,
  },
  appName: {
    fontSize: 16,
    marginBottom: 8,
  },
  switchValue: {
    fontSize: 16,
    marginBottom: 16,
  },
});

export default App;
